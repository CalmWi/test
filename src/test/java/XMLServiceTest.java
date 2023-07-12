import org.example.common.Status;
import org.example.model.Employee;
import org.example.model.Organization;
import org.example.service.XmlService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.example.service.OrganizationService.printOpenedOrganizations;

public class XMLServiceTest {
    private XmlService xmlService = new XmlService();
    private final List<Organization> organizations = new ArrayList<>();

    @Before
    public void setOrganizationList() {
        Organization organization1 = new Organization("org1", LocalDate.now(), Status.OPENED, new ArrayList<>());
        Organization organization2 = new Organization("org2", LocalDate.now(), Status.OPENED, new ArrayList<>());
        Organization organization3 = new Organization("org3", LocalDate.now(), Status.CLOSED, new ArrayList<>());

        Employee employee1 = new Employee("emp1", LocalDate.now(), null);
        Employee employee2 = new Employee("emp2", LocalDate.now(), null);
        Employee employee3 = new Employee("emp3", LocalDate.now(), null);
        Employee employee4 = new Employee("emp4", LocalDate.now(), null);

        organization1.getEmployees().add(employee1);
        organization1.getEmployees().add(employee2);
        organization1.getEmployees().add(employee3);

        organization2.getEmployees().add(employee4);
        organization2.getEmployees().add(employee3);

        organization3.getEmployees().add(employee4);
        organization3.getEmployees().add(employee3);

        organizations.add(organization1);
        organizations.add(organization2);
        organizations.add(organization3);
    }

    @Test
    public void serializationOrganizationsListTest() throws IOException {
        xmlService.serialiseToXml(organizations);
    }

    @Test
    public void deserializationOrganizationsListTest() throws IOException {
        List<Organization> result = xmlService.parseFromXml();
        Assert.assertEquals(result, organizations);

        printOpenedOrganizations(result);
    }
}
