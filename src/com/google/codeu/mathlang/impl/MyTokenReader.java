// Copyright 2017 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.codeu.mathlang.impl;

import java.io.IOException;

import com.google.codeu.mathlang.core.tokens.Token;
import com.google.codeu.mathlang.parsing.TokenReader;
import com.google.codeu.mathlang.core.tokens.NameToken;


// MY TOKEN READER
//
// This is YOUR implementation of the token reader interface. To know how
// it should work, read src/com/google/codeu/mathlang/parsing/TokenReader.java.
// You should not need to change any other files to get your token reader to
// work with the test of the system.
public final class MyTokenReader implements TokenReader {

  private String source;
  public MyTokenReader(String source) {
    // Your token reader will only be given a string for input. The string will
    // contain the whole source (0 or more lines).
    this.source = source;
    System.out.println(source);
  }

  @Override
  public Token next() throws IOException {
    // Most of your work will take place here. For every call to |next| you should
    // return a token until you reach the end. When there are no more tokens, you
    // should return |null| to signal the end of input.

    // If for any reason you detect an error in the input, you may throw an IOException
    // which will stop all execution.

    // First Test;
    if (source.length() == 0 || isEnd(source.charAt(0))) {
      return null;
    }
    int i = 0;
    String tokenString = "";
    while (isLetter(source.charAt(i) ) ) {
      tokenString += source.charAt(i);
      i++;
    }
    source = source.substring(i, source.length() );
    if (tokenString.length() > 0) {
      return new NameToken(source);
    }
    return null;
  }

  // Check if character is a letter
  public boolean isLetter(char c) {
    return Character.isLetter(c);
  }

  // Check if character is semi
  public boolean isEnd(char c) {
    return c == ';';
  }
}
