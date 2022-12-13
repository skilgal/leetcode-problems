/* 14. Longest Common Prefix


Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
 strs[i] consists of only lowercase English letters.

 * [https://leetcode.com/problems/longest-common-prefix/description/]
 */

object LongestCommonPrefix extends App {

  // Runtime: 585 ms (Beats 84.8%) Memory: 54.4Mb (Beats 84.21%)
  def longestCommonPrefix(strs: Array[String]): String = {

    def accumed(strs: Array[String], prefix: StringBuffer): String = {
      val firsts = strs.map(s => s take 1).filter(_.nonEmpty)
      val chars  = firsts.distinct
      if (firsts.size == strs.size && chars.size == 1)
        accumed(strs.map(_.drop(1)), prefix append chars.head)
      else prefix.toString
    }

    accumed(strs, new StringBuffer())
  }

  assert(longestCommonPrefix(Array("dog", "racecar", "car")) == "")
  assert(longestCommonPrefix(Array("flower", "flow", "flight")) == "fl")
  assert(longestCommonPrefix(Array("")) == "")
  assert(longestCommonPrefix(Array("a")) == "a")
  assert(longestCommonPrefix(Array("", "b")) == "")

}
