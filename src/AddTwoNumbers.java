/**
 * Created by Lx on 2015/11/24.
 */
public class AddTwoNumbers {

//     Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //自己实现，又笨又长！
   /* public class TwoSum {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int and = l1.val + l2.val;//相加结果
            int carry = 0;//进位
            if(and > 9){
                carry = 1;
                and %= 10;
            }
            ListNode result = new ListNode(and);
            ListNode next1 = l1;//list1的下一个结点
            ListNode next2 = l2;//list2的下一个结点
            ListNode resultGuard = result;//两个节点中靠后的一个
            ListNode resultForward;//两个节点中靠前的一个
            while (next1.next != null && next2.next != null){
                next1 = next1.next;
                next2 = next2.next;
                and = next1.val + next2.val + carry;
                carry = 0;
                if(and > 9){
                    carry = 1;
                    and %= 10;
                }
                resultForward = new ListNode(and);
                resultGuard.next = resultForward;
                resultGuard = resultForward;
            }

            //到两个list长度一样时，可能出现进位情况
            if(next1.next == null && next2.next == null){
                if(carry > 0){
                    resultForward = new ListNode(carry);
                    resultGuard.next = resultForward;
                    return result;
                }
            }

            //1有剩余时
            while (next1.next != null){
                next1 = next1.next;
                and = next1.val + carry;
                carry = 0;
                if(and > 9){
                    carry = 1;
                    and %= 10;
                }
                resultForward = new ListNode(and);
                resultGuard.next = resultForward;
                resultGuard = resultForward;
            }

            //2有剩余时
            while (next2.next != null){
                next2 = next2.next;
                and = next2.val + carry;
                carry = 0;
                if(and > 9){
                    carry = 1;
                    and %= 10;
                }
                resultForward = new ListNode(and);
                resultGuard.next = resultForward;
                resultGuard = resultForward;
            }

            if(carry > 0){
                resultForward = new ListNode(carry);
                resultGuard.next = resultForward;
                return result;
            }
            return result;
        }
    }*/

    public class Solution{
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode c1 = l1;
            ListNode c2 = l2;
            ListNode result = new ListNode(0);
            ListNode d = result;
            ListNode e = d;
            int sum = 0;
            while(c1 != null || c2 != null){
                if(c1 != null){
                    sum += c1.val;
                    c1 = c1.next;
                }

                if(c2 != null){
                    sum += c2.val;
                    c2 = c2.next;
                }

                d.val = sum % 10;
                d.next = new ListNode(sum/=10);
                e = d;//用e节点记住当前最后一个节点，即e始终是d前面的一个节点
                d = d.next;
            }
            if(d.val < 1){
                e.next = null;
            }
            return result;
        }
    }
}
