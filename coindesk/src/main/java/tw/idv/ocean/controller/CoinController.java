package tw.idv.ocean.controller;

import static tw.idv.ocean.util.CommonUtil.getFormattedDateStr;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import tw.idv.ocean.po.Coin;
import tw.idv.ocean.repository.CoinRepository;

@RestController
public class CoinController {
	private static final String COINDESK_URL = "https://api.coindesk.com/v1/bpi/currentprice.json";
	@Autowired
	private CoinRepository repository;

	@GetMapping("api")
	public ObjectNode api() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		String respStr = restTemplate.getForObject(COINDESK_URL, String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode respNode = objectMapper.readValue(respStr, ObjectNode.class);
		respNode.put("time", getFormattedDateStr(respNode.get("time").get("updatedISO")));
		respNode.remove("disclaimer");
		respNode.remove("chartName");
		respNode.get("bpi").forEach(this::processBpi);
		return respNode;
	}
	
	private void processBpi(JsonNode jsonNode) {
		ObjectNode objectNode = (ObjectNode) jsonNode;
		final String code = objectNode.get("code").asText();
		Optional<Coin> coinOptional = repository.findById(code);
		final String chiName = coinOptional.isPresent() ? coinOptional.get().getChiName() : "未知";
		objectNode.put("chiName", chiName);
		objectNode.remove("symbol");
		objectNode.put("rate", objectNode.get("rate_float").asDouble());
		objectNode.remove("description");
		objectNode.remove("rate_float");
	}
}
