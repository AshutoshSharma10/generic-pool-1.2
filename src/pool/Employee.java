package pool;

public class Employee {

	  private static int base = 0;


	  private int id;

	  private String name;

	  public Employee() {
	    this.id = base++;
	  }

	  public int getId() {
	    return this.id;
	  }

	  public String getName() {
	    return this.name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public void doWork() {
	    // does nothing
	  }

	  public String toString() {
	    return ("Id: " + this.id + ", Name: " + this.name);
	  }

	  public void finalize() {
	    System.err.println("Employee " + toString() + " made redundant");
	  }
	}