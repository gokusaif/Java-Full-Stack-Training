import { NgModule } from '@angular/core';
import { RouterModule,  Route } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AboutComponent } from './about/about.component';
import { UserComponent } from './user/user.component';
import { AuthGuard } from './auth.guard';
import { AdminComponent } from './admin/admin.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';


const routes: Route[] = [
    { path: '' , component: HomeComponent},
    { path: 'login', component: LoginComponent},
    { path: 'register', component: RegisterComponent},
    { path: 'about', component: AboutComponent},
    { path: 'user', component: UserComponent,
    canActivate: [AuthGuard],
  data: {expectedRoles: ['admin', 'user']}},
    { path: 'admin', component: AdminComponent,
    canActivate: [AuthGuard],
  data: {expectedRoles: ['admin']}},
  { path: '**', component: PagenotfoundComponent},
  ] ;

@NgModule({
    imports: [
        RouterModule.forRoot(routes)
    ],
    exports: [
        RouterModule
    ]
})

export class AppRoutingModule {
}
