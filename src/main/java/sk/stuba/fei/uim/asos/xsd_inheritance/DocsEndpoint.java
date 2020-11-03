package sk.stuba.fei.uim.asos.xsd_inheritance;

import sk.stuba.fei.uim.asos.xsd_inheritance.ws.*;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.time.LocalDate;

@WebService(name = "DocsServicePortType", targetNamespace = "docs")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class
})
public class DocsEndpoint implements DocsServicePortType {

    public Docs list() {
        Docs docs = new Docs();

        TravelDoc travelDoc = new TravelDoc();
        travelDoc.setId(0);
        travelDoc.setCreated(LocalDate.now());
        travelDoc.setStartDate(LocalDate.now());
        travelDoc.setStartDate(LocalDate.now().plusDays(5));
        travelDoc.setPurpose("travel");
        travelDoc.setValidity("worldwide");

        InjuryDoc injuryDoc = new InjuryDoc();
        injuryDoc.setCreated(LocalDate.now());
        injuryDoc.setStartDate(LocalDate.now());
        injuryDoc.setStartDate(LocalDate.now().plusDays(5));
        injuryDoc.setDeathValue(25_000f);
        injuryDoc.setPermanentValue(30_000f);

        docs.getDoc().add(travelDoc);
        docs.getDoc().add(injuryDoc);
        return docs;
    }
}
