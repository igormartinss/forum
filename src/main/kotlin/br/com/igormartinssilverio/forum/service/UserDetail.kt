package br.com.igormartinssilverio.forum.service

import br.com.igormartinssilverio.forum.model.User
import org.springframework.security.core.userdetails.UserDetails

class UserDetail(private val userToLogin: User): UserDetails {

    override fun getAuthorities() = userToLogin.role

    override fun getPassword() = userToLogin.password

    override fun getUsername() = userToLogin.username

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}