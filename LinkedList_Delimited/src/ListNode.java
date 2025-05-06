/**
 * 给你一个链表的头节点 head 和一个特定值 x ，
 * 请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *你应当 保留 两个分区中每个节点的初始相对位置。
 */
  //Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = head;
        while(cur != null){
            if(cur.val < x){
                if(bs == null){
                    bs = cur;
                    be = cur;
                }
                else{
                    be.next = cur;
                    be = be.next;
                }
            }
            else {
                if(as == null){
                    as = cur;
                    ae = cur;
                }else{
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        if(ae != null){
            ae.next = null;
        }
        if(bs == null){
            return as;
        }
        be.next = as;
        return bs;
    }
}