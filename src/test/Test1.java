//窗口：.win:length_batch
//事件：对象
package test;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;


class AppleListener implements UpdateListener
{

	public void update(EventBean[] newEvents, EventBean[] oldEvents)
	{
		if (newEvents != null)
		{
			Double avg = (Double) newEvents[0].get("avg(price)");
			System.out.println("Apple's average price is " + avg);
		}
	}

}
public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider();

		EPAdministrator admin = epService.getEPAdministrator();
		EPRuntime runtime = epService.getEPRuntime();
		
		String product = Apple.class.getName();
		//统计窗口限定为：事件个数为2。每攒够2个就计算一次，然后清空队列。
		String epl = "select avg(price) from " + product + ".win:length_batch(2)";

		EPStatement state = admin.createEPL(epl);
		state.addListener(new AppleListener());


		Apple apple1 = new Apple();
		apple1.setPrice(5);
		runtime.sendEvent(apple1);

		Apple apple2 = new Apple();
		apple2.setPrice(2);
		runtime.sendEvent(apple2);

		Apple apple3 = new Apple();
		apple3.setPrice(5);
		runtime.sendEvent(apple3);
		
		Apple apple4 = new Apple();
		apple4.setPrice(7);
		runtime.sendEvent(apple4);
	}
}
/**Apple's average price is 3.5
Apple's average price is 6.0
*/