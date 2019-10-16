package com.github.andavid.ds.algorithm.stringmatch;

/**
 * RK 字符串匹配算法
 *
 * https://novoland.github.io/%E7%AE%97%E6%B3%95/2014/07/26/Hash%20&%20Rabin-Karp%E5%AD%97%E7%AC%A6%E4%B8%B2%E6%9F%A5%E6%89%BE%E7%AE%97%E6%B3%95.html
 */
public class RabinKarp {

  /** 一个很大的素数 */
  private static long M = 1000000000000000003L;
  //M = BigInteger.valueOf((long) Math.pow(10, 18)).nextProbablePrime().longValue();

  /** 进制 */
  private static int R = 31;

  /** 模式字符串 */
  private String pattern;

  /** 模式字符串的长度 */
  private int K;

  /** 模式字符串的 hash 值 */
  private long patternHash;

  /** R^K % M */
  private long RK;

  public RabinKarp(String pattern) {
    this.pattern = pattern;
    if (pattern != null) {
      K = pattern.length();
    }

    patternHash = hash(pattern);
    System.out.println("patternHash = " + patternHash);

    RK = 1;
    for (int i = 0; i < K; i++) {
      RK = (RK * R) % M;
    }
  }

  public int search(String txt) {
    if (txt == null || txt.length() < K) {
      return -1;
    }

    long txtHash = hash(txt, 0, K);
    System.out.println("0.txtHash = " + txtHash);

    // 匹配第一个子串
    if ((txtHash == patternHash) && match(txt, 0)) {
        return 0;
    }

    for (int i = 1; i + K <= txt.length(); i++) {
      // 根据前一个子串的哈希值计算下一个子串的哈希值
      // 假设原来的字符串为 s，H(i) 表示从第 i 个字符开始的 K 个子字符串的哈希值
      // H(i) = s[i] * R^(K-1) + s[i+1] * R^(K-2) + ... + s[i+k-1] * R^0
      // H(i+1) = s[i+1] * R^(K-1) + s[i] * R^(K-2) + ... + s[i+k] * R^0
      // H(i+1) = (H(i) - s[i] * R^(K-1)) * R + S[i+K]
      // 即 i+1 处子串的 hash 可以由 i 处子串的 hash 直接计算而得，为了防止溢出在中间结果 % M
      // H(i+1) % M = [H(i) % M * R + s[i+k] - s[i] * R^k % M + M] % M
      txtHash = (txtHash * R  + txt.charAt(i + K - 1) - txt.charAt(i - 1) * RK % M  + M ) % M;
      System.out.println(i + ".txtHash = " + txtHash);
      if ((txtHash == patternHash) && match(txt, i)) {
          return i;
      }
    }

    return -1;
  }

  private boolean match(String txt, int start) {
    for (int i = 0; i < K; i++) {
      if (pattern.charAt(i) != txt.charAt(i + start)) {
        return false;
      }
    }
    return true;
  }

  private long hash(String str) {
    return hash(str, 0, str.length());
  }

  private long hash(String str, int start, int end) {
    long hash = 0;
    for (int i = start; i < end; i++) {
      hash = (hash * R + str.charAt(i)) % M;
    }
    return hash;
  }

}
