package pool;

import org.apache.commons.pool.impl.GenericObjectPool;

public class TestObjectPool {
	public static void main(String args[]) throws Exception {

		GenericObjectPool pool = new GenericObjectPool();
		pool.setFactory(new EmployeeFactory());

		for (int i = 0; i < 5; ++i) {
			pool.addObject(); 
		}

		pool.setTestOnBorrow(true);
		//pool.setTestOnReturn(true);
		pool.setMinEvictableIdleTimeMillis(1000);
		pool.setTimeBetweenEvictionRunsMillis(600);
		
		System.out.println();

		System.err.println("Number of employees in pool: " + pool.getNumIdle());
		Thread.currentThread().sleep(1500);

		Employee employee = null;
		for(int i=1;i<5;i++){
			System.out.println("	Before borrow object ");
			employee = (Employee) pool.borrowObject();
			System.out.println("	After borrow object ");
		}
		employee.setName("Fred Flintstone");
		employee.doWork();

		pool.returnObject(employee);
		System.err.println("Number of employees in pool: " + pool.getNumIdle());
	}
}
