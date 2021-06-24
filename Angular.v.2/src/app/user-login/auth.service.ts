import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  // BASE_PATH: 'http://localhost:8080'
  USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser'

  public username!: any;
  public password!: any;

  constructor(private http: HttpClient) {

  }

  authenticationService(username: string, password: string) {
    //return this.http.get(`http://localhost:8080/api/v1/basicauth`,
    return this.http.get(`http://localhost:9096/hms/user`,
      { headers: { authorization: this.createBasicAuthToken(username, password) } }).pipe(map((res) => {
        this.username = username;
        this.password = password;
        console.log("result"+res);
        console.log(username);
        this.registerSuccessfulLogin(username, password);
      }),
      catchError((err, caught) => {
        console.error(err);
        throw err;
      }
      )
    )
      
  }

  createBasicAuthToken(username: String, password: String) {
    console.log('Basic ' + window.btoa(username + ":" + password));
    console.log(window.atob(window.btoa(username + ":" + password)));
    return 'Basic ' + window.btoa(username + ":" + password);
  }

  registerSuccessfulLogin(username:string, password:string) {
    sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME, username)
  }

  logout() {
    sessionStorage.removeItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
    this.username = null;
    this.password = null;
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    console.log(user);
    if (user === null) return false
    return true
  }

  getLoggedInUserName() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return ''
    return user
  }
}
