package at.htl.restrauntmanagement.control;

import at.htl.restrauntmanagement.entity.Customer;
import at.htl.restrauntmanagement.entity.Table;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class TableRepositoryTest {

    @Inject
    TableRepository tableRepository;

    @Test
    @Order(3000)
    void saveTable(){
        Table table = tableRepository.saveTable(new Table("1L", 3));

        assertThat(table.getTableNr()).isEqualTo("1L");
    }

    @Test
    @Order(3001)
    void getAllTables() {
        tableRepository.saveTable(new Table("1L", 3));
        tableRepository.saveTable(new Table("1M", 3));

        List<Table> tables = tableRepository.getAllTables();

        assertThat(tables.size()).isEqualTo(2);
    }


    @Test
    @Order(3002)
    void validateTable(){
        try{
            tableRepository.validateTable(new Table("1L", 3));
        }
        catch (ConstraintViolationException ex) {
            fail(ex.toString());
        }
    }
}