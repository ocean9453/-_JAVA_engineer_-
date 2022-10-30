package tw.idv.ocean.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tw.idv.ocean.po.Coin;

@RepositoryRestResource(path = "coin", collectionResourceRel = "coin")
public interface CoinRepository extends JpaRepository<Coin, String> {
}
