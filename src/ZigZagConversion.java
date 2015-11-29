/**
 * Created by Lx on 2015/11/29.
 * 思想：开numRows个stringbudilder,遍历原String的每一个字符,将扫描的当前字符加入到结果中第i行对应的第i个sb中，
 * 最后将所有sb汇总成一个sb，注意边界检查，可能会出现sb下标index超出边界的情况，这时候只需要判断并作相应处理
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(s.length() < numRows || numRows == 1){
            return s;
        }

        StringBuilder[] sbs = new StringBuilder[numRows];
        StringBuilder result = new StringBuilder();
        for(int i = 0;i < numRows;i++){
            sbs[i] = new StringBuilder();
        }

        int mode = 1;//mode=1下降扫描，mode=0上升扫描加入sb
        int index = 0;
        for(int i = 0;i < s.length();i++){
            //index超出边界，说明下降到了底部，开始上升阶段，mode变为1，index-2
            if(index == numRows){
                mode = 0;
                index-=2;
            }else if(index < 0){
                index+=2;
                mode = 1;
            }

            if(mode == 1){
                sbs[index].append(s.charAt(i));
                index++;
            }else{
                sbs[index].append(s.charAt(i));
                index--;
            }
        }

        for(int i = 0;i < sbs.length;i++){
            result.append(sbs[i].toString());
        }

        return result.toString();
    }

    public static void main(String[] args){
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        System.out.println(zigZagConversion.convert("PAYPALISHIRING",3));
    }
}
