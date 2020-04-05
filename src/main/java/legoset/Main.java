package legoset;

import java.time.Year;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Main {

    public static void main(String[] args) {

        LegoSet set = new LegoSet();
        set.setName("Imperial TIE Fighter");
        set.setNumber("75211");
        set.setTheme("Star Wars");
        set.setSubtheme("Solo");
        set.setYear(Year.parse("2018"));
        set.setPieces(519);
        Set<String> tags = new LinkedHashSet<String>();
        tags.add("Starfighter");
        tags.add("Stormtrooper");
        tags.add("Star Wars");
        tags.add("Solo");
        set.setTags(tags);
        List<Minifig> minifigs = new ArrayList<Minifig>();
        minifigs.add(new Minifig("Imperial Mudtrooper", 2));
        minifigs.add(new Minifig("Imperial Pilot", 1));
        minifigs.add(new Minifig("Mimban Stormtrooper", 1));
        set.setMinifigs(minifigs);
        set.setWeight(new Weight("kg", 0.89));
        set.setUrl("https://brickset.com/sets/75211-1/Imperial-TIE-Fighter");

        try {
            JAXBContext context = JAXBContext.newInstance(LegoSet.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.marshal(set, System.out);
        } catch(JAXBException e) {
            System.out.println(e.getMessage());
        }
    }
}