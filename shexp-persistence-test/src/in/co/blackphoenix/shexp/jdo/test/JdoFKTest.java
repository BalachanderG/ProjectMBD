/**
 * 
 */
package in.co.blackphoenix.shexp.jdo.test;


import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;

import in.co.blackphoenix.shexp.jdo.PMF;
import in.co.blackphoenix.shexp.jdo.PerUserTransaction;
import in.co.blackphoenix.shexp.jdo.Bill;

/**
 * @author Manoj
 *
 */
public class JdoFKTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		PersistenceManager pm = PMF.get();
		Transaction tx= pm.currentTransaction();
		try{
			tx.begin();
			{
				Bill myFirstBill = new Bill(10 ,100, 10);
				
				
				PerUserTransaction participant1 = new PerUserTransaction("Manoj", 2);
				PerUserTransaction participant2 = new PerUserTransaction("Sappa", 3);
				PerUserTransaction participant3 = new PerUserTransaction("Kaana", 3);
				PerUserTransaction participant4 = new PerUserTransaction("Aichu", 2);
				
				myFirstBill.getMyParticipants().add(participant1);
				myFirstBill.getMyParticipants().add(participant2);
				myFirstBill.getMyParticipants().add(participant3);
				myFirstBill.getMyParticipants().add(participant4);
				
				pm.makePersistent(myFirstBill);


				pm.makePersistent(participant1);
				pm.makePersistent(participant2);
				pm.makePersistent(participant3);
				pm.makePersistent(participant4);
				
				tx.commit();
			}

		}
		finally{
			if(tx.isActive())
				tx.rollback();
			pm.close();
		}

	}

}
