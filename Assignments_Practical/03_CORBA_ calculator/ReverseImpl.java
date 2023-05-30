import ReverseModule.ReversePOA;

import java.util.*;

public class extends ReversePOA{
    
    public String reverse_string(String name){
        StringBuilder sb = new StringBuilder();
        sb.reverse();
        return "Server Send : " + sb.toString();
    }
}