package com.testing.end2endproject;

import java.io.IOException;

import org.testng.annotations.Test;

import base.Base;

public class NewTest extends Base{
  @Test
  public void f() throws IOException {
	  startBrowser();
  }
}
