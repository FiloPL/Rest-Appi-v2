package ttsw.filopl.restappiv2.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ttsw.filopl.restappiv2.item.Item;


/**
 * Created by T. Filo Zegarlicki on 20.07.2022
 **/

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}