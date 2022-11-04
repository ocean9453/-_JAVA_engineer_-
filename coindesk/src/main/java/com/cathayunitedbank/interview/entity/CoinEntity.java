package com.cathayunitedbank.interview.entity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.cathayunitedbank.interview.entity.CoinEntity.Bpi;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
public class CoinEntity {
    @JsonRootName("time")
    @Entity
    @Table(name = "UPDATETIME")
    @EqualsAndHashCode(callSuper=false)
    @NoArgsConstructor
    @Data
    public class UpdateTime extends BaseEntity{
        @Column(name = "updated")
        private String updated;
        @Column(name = "updatedISO")
        private String updatedISO;
        @Column(name = "updateduk")
        private String updateduk;
    }
    @JsonRootName("bpi")
    @Entity
    @Table(name = "BPI")
    @EqualsAndHashCode(callSuper=false)
    @Data
    public static class Bpi extends BaseEntity{
        @Column(name = "code")
        private String code;
        @Column(name = "symbol")
        private String symbol;
        @Column(name = "rate")
        private String rate;
        @Column(name = "description")
        private String description;
        @Column(name = "rate_float")
        private String rate_float;
    }

    @JsonAlias("time")
    private UpdateTime updateTime;
    private String disclaimer;
    private String chartName;
    @JsonDeserialize(using = BpiDeserializer.class)
    private List<Bpi> bpi;
}

class BpiDeserializer extends JsonDeserializer<List<Bpi>> {

    @Override
    public List<Bpi> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        JsonNode node = p.getCodec().readTree(p);
        ObjectMapper objectMapper = new ObjectMapper();
        List<Bpi> list = new ArrayList<>();
        node.forEach(e -> list.add(objectMapper.convertValue(e, new TypeReference<Bpi>(){})));
        return list;
    }
}