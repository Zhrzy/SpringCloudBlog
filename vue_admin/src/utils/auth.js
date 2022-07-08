import Cookies from 'js-cookie'

const TokenKey = 'blog-admin-token'

export function getToken() {
  return Cookies.get(TokenKey)
}

//设置token到cookie
export function setToken(token) {
  return Cookies.set(TokenKey, token)
}

export function removeToken() {
  return Cookies.remove(TokenKey)
}
