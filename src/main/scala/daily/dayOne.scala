package daily

import structure._

object Solution {
  def maxDepth(root: TreeNode): Int = {
    if (root == null) 0
    else Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
  }

  def isLeaf(root: TreeNode): Boolean = {
    root != null && root.left == null && root.right == null
  }

  def hasPathSum(root: TreeNode, sum: Int): Boolean = {
    def hasPathSumRec(root: TreeNode, sum: Int): Boolean = {
      if (isLeaf(root)) sum - root.value == 0
      else if (root == null) false
      else hasPathSumRec(root.left, sum - root.value) ||
        hasPathSumRec(root.right, sum - root.value)

    }

    if (root == null) false
    else hasPathSumRec(root, sum)
  }
}

object SolutionTester extends App {
  println(
    Solution.hasPathSum(
      new TreeNode(5,
        new TreeNode(4,
          new TreeNode(11,
            new TreeNode(7, null, null),
            new TreeNode(2, null, null)
          ),
          null
        ),
        new TreeNode(8,
          new TreeNode(13, null, null),
          new TreeNode(4, null, new TreeNode(1, null, null))
        )
      ),
      22
    )
  )

  println(Solution.hasPathSum(new TreeNode(1, new TreeNode(2, null), null), 1))

  println(Solution.hasPathSum(new TreeNode(-2, null, new TreeNode(-3, null, null)), -5))
}
