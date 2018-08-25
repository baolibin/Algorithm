package libin.base

import org.apache.commons.net.util.Base64

/**
  * Copyright (c) 2018/8/13. xixi Inc. All Rights Reserved.
  * Authors: libin <2578858653@qq.com>
  *
  * Purpose :
  */

object Crypto {
  def main(args: Array[String]) {
    println(md5("asd"))
  }

  def md5(s: String): String = {
    val md = java.security.MessageDigest.getInstance("MD5")
    val b = s.getBytes("UTF-8")
    md.update(b, 0, b.length)
    new java.math.BigInteger(1, md.digest()).toString(16)
  }

  def sha1(s: String): String = {
    val md = java.security.MessageDigest.getInstance("sha1")
    Base64.encodeBase64URLSafeString(md.digest(s.getBytes())).substring(0, 16)
  }

  def md5Number(s: String): Long = {
    val md = java.security.MessageDigest.getInstance("MD5")
    val b = s.getBytes("UTF-8")
    md.update(b, 0, b.length)
    new java.math.BigInteger(1, md.digest()).longValue()
  }
}
