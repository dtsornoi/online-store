import {Component, OnInit} from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import {TokenStorageService} from '../../service/token-storage.service';
import {Router} from '@angular/router';
import {UserAccount} from '../../model/user-account.module';

@Component({
  selector: 'main-nav',
  templateUrl: './main-nav.component.html',
  styleUrls: ['./main-nav.component.css']
})
export class MainNavComponent implements OnInit{

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );
  isLoggedIn: boolean = false;
  roles = [];
  currentUser: UserAccount = {}

  constructor(
    private breakpointObserver: BreakpointObserver,
    private token: TokenStorageService,
    private router: Router
  ) {}

  ngOnInit(): void {
    if (this.token.getToken()){
      this.isLoggedIn = true;
      this.currentUser = this.token.getUser();
      this.roles = this.currentUser.roles
      console.log(this.roles)
    }
  }

  hasRole(authority) {
    for (let role of this.roles) {
      return role === authority;
    }
  }

  toUpperCase(str: string): string {
    return str.charAt(0).toUpperCase() + str.slice(1).toLowerCase();
  }

  logout() {
    this.token.signOut();
    window.location.reload();
  }

}
