package pool;

import org.apache.commons.pool.BasePoolableObjectFactory;

public class EmployeeFactory extends BasePoolableObjectFactory {
	@Override
	  public Object makeObject() {
	    return new Employee();
	  }
	  @Override
	  public boolean validateObject(Object obj) {
		System.out.println("	In validate method " ); 
		
	    if(obj instanceof Employee) {
	      if(((Employee)obj).getName() == null)
	        return true;
	    }
	    return false;
	  }
	  @Override
	  public void passivateObject(Object obj) throws Exception {
	    if(obj instanceof Employee) {
	      ((Employee)obj).setName(null);
	    } else throw new Exception("Unknown object");
	  }
	}
