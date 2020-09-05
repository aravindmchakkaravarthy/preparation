package leetcode.string.easy;

/**
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 *
 * A defanged IP address replaces every period "." with "[.]".
 *
 *
 *
 * Example 1:
 *
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 * Example 2:
 *
 * Input: address = "255.100.50.0"
 * Output: "255[.]100[.]50[.]0"
 *
 *
 * Constraints:
 *
 * The given address is a valid IPv4 address.
 */
public class DefangingAnIpAddress {

    public String defangIPaddr(String address) {
        StringBuilder s = new StringBuilder();
        for(char c:address.toCharArray()){
            if(c == '.'){
                s.append("[.]");
            }else{
                s.append(c);
            }
        }
        return s.toString();
    }

    public String defangIpAddress2(String address){
        return address.replaceAll("[.]", "[.]");

    }

    public static void main(String[] args){
        DefangingAnIpAddress d = new DefangingAnIpAddress();
        System.out.println(d.defangIPaddr("1.1.1.1"));
        System.out.println(d.defangIpAddress2("1.1.1.1"));
    }
}
