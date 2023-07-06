package subway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class StationRepositoryTest {
    @Autowired
    private StationRepository stations;

    @Test
    void save() {
        Station expected = new Station("잠실역");
        Station actual = stations.save(expected);
        assertThat(actual.getId()).isNotNull();
        assertThat(actual.getName()).isEqualTo("잠실역");
    }

    @Test
    void findByName() {
        String expected = "잠실역";
        stations.save(new Station(expected));
        String actual = stations.findByName(expected).getName();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void identity() {
        Station station1 = stations.save(new Station("잠실역"));
        Station station2 = stations.findById(station1.getId()).get();
        assertThat(station1 == station2).isTrue();
    }

    @Test
    void test() {
        Station station = new Station("잠실역");
        stations.save(station);
        System.out.println("----- name ----");
        Station find = stations.findByName("잠실역");
        System.out.println("------end------");
        stations.findById(find.getId());

    }
}
