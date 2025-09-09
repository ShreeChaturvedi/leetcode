

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
    public:
        ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
            ListNode* result = new ListNode(), *p = result;
            int sum = 0;
            while (l1 != nullptr && l2 != nullptr) {
                sum += l1->val + l2->val;
                result->next = new ListNode(sum % 10);
                result = result->next;
                l1 = l1->next;
                l2 = l2->next;
                sum /= 10;
            }

            while (l1 != nullptr) {
                sum += l1->val;
                result->next = new ListNode(sum % 10);
                result = result->next;
                l1 = l1->next;
                sum /= 10;
            }

            while (l2 != nullptr) {
                sum += l2->val;
                result->next = new ListNode(sum % 10);
                result = result->next;
                l2 = l2->next;
                sum /= 10;
            }

            if (sum > 0) result->next = new ListNode(sum);

            return p->next;
        }
    };