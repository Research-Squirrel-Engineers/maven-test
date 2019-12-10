package link.squirrel.maventest;

import org.linkedgeodesy.jenaext.config.POM_jenaext;
import org.linkedgeodesy.jenaext.log.Logging;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.jena.riot.Lang;
import org.linkedgeodesy.jenaext.model.JenaModel;
import org.linkedgeodesy.jenaext.run.FileOutput;

/**
 * main class for running
 */
public class Main {

    /**
     * main method
     *
     * @param args
     * @throws IOException
     * @throws SQLException
     */
    public static void main(String[] args) throws IOException, SQLException {
        List<String> o = new ArrayList();
        try {
            // read in turtle, write json-ld, read in json-ld, write N-Triples
            String turtle = "<http://example.org/#spiderman> <http://www.perceive.net/schemas/relationship/enemyOf> <http://example.org/#green-goblin> ; <http://xmlns.com/foaf/0.1/name> \"Spiderman\" .";
            JenaModel jm = new JenaModel();
            jm.readRDF(turtle, Lang.TURTLE);
            o.add(jm.getModelAsRDFFormatedString("RDF/XML"));
            FileOutput.writeFile(o);
        } catch (Exception e) {
            System.out.println(Logging.getMessageJSON(e, "link.squirrel.maventest.run.Main").toJSONString());
            FileOutput.writeFile(o);
        }
    }

}
