"""给定一个有 N 个结点的二叉树的根结点 root，树中的每个结点上都对应有 node.val 枚硬币，并且总共有 N 枚硬币。

在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。(移动可以是从父结点到子结点，或者从子结点移动到父结点。)。

返回使每个结点上只有一枚硬币所需的移动次数。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/distribute-coins-in-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。"""
from collections import deque
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class TN:
    def __init__(self, val=0, left=None, right=None, need=0, give=0, cost=0):
        self.val = val
        self.left = left
        self.right = right
        self.need = need
        self.give = give
        self.cost = cost


class Solution:
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        r = TN(val=root.val, left=None, right=None, need=0, give=0, cost=0)
        self.initial(root, r)
        self.fun(r)
        return r.cost

    def initial(self, p, r):
        if p.left is not None:
            tmp = TN(val=p.left.val)
            r.left = tmp
            self.initial(p.left, r.left)
        if p.right is not None:
            tmp = TN(val=p.right.val)
            r.right = tmp
            self.initial(p.right, r.right)

    def fun(self, r):
        if r.left is None and r.right is None:
            r.need = 1 - r.val
            r.give = r.val - 1
            r.cost = 0
            return
        if r.left is not None:
            self.fun(r.left)
        if r.right is not None:
            self.fun(r.right)
        if r.left is not None and r.right is None:
            if r.left.need > 0:
                r.need = r.left.need
                r.give = -r.left.need
                r.cost = r.left.need
            elif r.left.give > 0:
                r.need = -r.left.give
                r.give = r.left.give
                r.cost = r.left.give
            r.cost += r.left.cost
        elif r.left is None and r.right is not None:
            if r.right.need > 0:
                r.need = r.right.need
                r.give = -r.right.need
                r.cost = r.right.need
            elif r.right.give > 0:
                r.need = -r.right.give
                r.give = r.right.give
                r.cost = r.right.give
            r.cost += r.right.cost
        elif r.left is not None and r.right is not None:
            if r.left.need >= 0 and r.right.need >= 0:
                r.need = r.left.need + r.right.need
                r.give = -r.left.need - r.right.need
                r.cost = r.right.need + r.left.need
            elif r.left.need >= 0 and r.right.give >= 0:
                r.need = r.left.need - r.right.give
                r.give = -r.left.need + r.right.give
                r.cost = r.left.need + r.right.give
            elif r.left.give >= 0 and r.right.need >= 0:
                r.need = r.right.need - r.left.give
                r.give = -r.right.need + r.left.give
                r.cost = r.right.need + r.left.give
            elif r.left.give >= 0 and r.right.give >= 0:
                r.need = -r.left.give - r.right.give
                r.give = r.left.give + r.right.give
                r.cost = r.right.give + r.left.give
            r.cost += (r.left.cost + r.right.cost)
        r.need += (1 - r.val)
        r.give += (r.val - 1)


class Solution1:
    def deserialize(self, data):
        if not data:
            return None

        nodes = [TreeNode(val=val) if val is not None else None for val in data]
        root = nodes[0]
        queue = deque([root])
        i = 1

        while queue and i < len(nodes):
            node = queue.popleft()

            if node is not None:
                node.left = nodes[i]
                node.right = nodes[i + 1]
                queue.append(node.left)
                queue.append(node.right)
                i += 2

        return root

data = [0,0,0,None,0,0,0,None,None,None,None,0,0,0,0,6,None,0,0,0,None,None,None,5,None,None,None,7,None,2,None,None,0,None,0,None,0]
solution = Solution1()
root = solution.deserialize(data)

solu = Solution()
print(solu.distributeCoins(root))