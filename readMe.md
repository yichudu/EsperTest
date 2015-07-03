EsperTest
=
##简介
esper入门DEMO

##常用窗口
win:length(size)	//攒够size条数据后触发UpdateListener()函数。滑动窗口，攒满之后新来一个移除一个，并触发。
win:length_batch(size) //攒够size条数据后触发，并清空队列。再攒满了再触发。
win:time(time period)	//第一次触发在period秒后，然后每一秒触发一次。
win:time_batch(time period) //每period秒触发一次。
win:keepall()				//无参数，记录所有进入的数据，除非使用delete操作，才能从窗口移出数据
std:unique(criteria)	//对不同的criteria[例如:id]保留其最近的一条事件