package main.java;

import java.util.HashMap;
import java.util.Map;

public class PopOrderTest {

    public static boolean isPopOrder(int[] stack,int[] pop)
    {
        Map<Integer,Integer> stackMap = new HashMap<>();
        for(int i=0;i<stack.length;i++)
        {
            stackMap.put(stack[i],i);
        }

        for(int popValue : pop)
        {
            if(stackMap.get(popValue)==null){
                return false;
            }
        }

        int popFirst = stackMap.get(pop[0]);
        int popFlag=stack.length;
        int index = pop.length;
        for(int i=0;i<pop.length;i++)
        {
            if(popFirst > stackMap.get(pop[i])){
                index = i;
                popFlag = stackMap.get(pop[i]);
                break;
            }
        }

        for(int i=index;i<pop.length;i++)
        {
            if(popFlag < stackMap.get(pop[i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        int[] push = {1,2,3,4,5};
        int[] pop = {4,5,3,2,1};
        int[] errorPop ={3,5,4,1,2};

        System.out.println(isPopOrder(push,pop));
        System.out.println(isPopOrder(push,errorPop));
    }
}
