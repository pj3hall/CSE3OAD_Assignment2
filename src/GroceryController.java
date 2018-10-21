import java.lang.reflect.Field;
import java.util.List;

public class GroceryController {

	private FridgeDSC fridgeDSC;

	public GroceryController(String dbHost, String dbUserName, String dbPassword) throws Exception {
		fridgeDSC = new FridgeDSC(dbHost, dbUserName, dbPassword);

		try {
			fridgeDSC.connect();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<Grocery> get() throws Exception {
        //TODO 06: what should this method return? HINT: a relevant call to a fridgeDSC method
        return fridgeDSC.getAllGroceries();
	}

	public Grocery get(int id) throws Exception {
		//TODO 07: what should this method return? HINT: a relevant call to a fridgeDSC method
        return fridgeDSC.searchGrocery(id);
	}

	public int add(Grocery g) throws Exception {
		// TODO 08: validate argument g, using Validation Framework
        Validator.validate(g);
        List<Field> fields = Validator.getInheritedDeclaredFields(g);
        System.out.println("Number of error messages: " + fields.size());
        for(Field msg: fields)
        {
            System.out.println(msg);
        }

        String name = g.getItemName();
        Integer quantity = g.getQuantity();
        FridgeDSC.SECTION section = g.getSection();

        // TODO 09: make a relevant call to a fridgeDSC method
        int addedId = fridgeDSC.addGrocery(name, quantity, section);

		// TODO 10: this method should return the id of the newly created grocery
        System.out.println("New ID: " + addedId);
        return addedId;
	}

	public Grocery update(int id) throws Exception {
		// TODO 11: make a relevant call to a fridgeDSC method
        fridgeDSC.useGrocery(id);

		// TODO 12: this method should return the updated grocery object
		return fridgeDSC.searchGrocery(id);
	}

	public int delete(int id) throws Exception {
		// TODO 13: make a relevant call to a fridgeDSC method
        fridgeDSC.removeGrocery(id);

		// TODO 14: this method should return what ever the fridgeDSC method call (TODO 13) returns
        return id;
	}

	// To perform some quick tests
	public static void main(String [] args) throws Exception {
		try {
            //GroceryController gc = new GroceryController("latcs7.cs.latrobe.edu.au:3306", "your-mysql-username", "your-mysql-password");
            GroceryController gc = new GroceryController("localhost:3306/fridgedb", "", "");

            /*// test getAll
			System.out.println(gc.get());

			// test get
			System.out.println(gc.get(8));*/

            // test add
            //Item item = new Item("Fish", true);
            //System.out.println(gc.add(new Grocery(item, 10, FridgeDSC.SECTION.MEAT)));

            // test update
            //System.out.println(gc.update(34));

            // test delete
            System.out.println(gc.delete(39));

		} catch (Exception exp) {
			exp.printStackTrace();
		}

	}
}