package com.songhwa.insulin.auth;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class UserAuthentication implements Authentication {
  private static final long serialVersionUID = -8195556895375181522L;

  private String userid;
  private String username;
  private Collection<? extends GrantedAuthority> authorities;
  private boolean authenticated;

  public UserAuthentication(String userid, String username, Collection<? extends GrantedAuthority> authorities, boolean authenticated) {
    this.userid = userid;
    this.username = username;
    this.authorities = authorities;
    this.authenticated = authenticated;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.security.Principal#getName()
   */
  @Override
  public String getName() {
    return userid + "|" + username;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.core.Authentication#getAuthorities()
   */
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.authorities;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.core.Authentication#getCredentials()
   */
  @Override
  public Object getCredentials() {
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.core.Authentication#getDetails()
   */
  @Override
  public Object getDetails() {
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.core.Authentication#getPrincipal()
   */
  @Override
  public Object getPrincipal() {
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.core.Authentication#isAuthenticated()
   */
  @Override
  public boolean isAuthenticated() {
    return this.authenticated;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.security.core.Authentication#setAuthenticated(boolean)
   */
  @Override
  public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
    this.authenticated = isAuthenticated;
  }

}
