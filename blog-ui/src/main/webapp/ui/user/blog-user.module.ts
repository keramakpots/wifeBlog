import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BlogUserComponent } from './blog-user.component';
import { BlogUserService } from './blog-user.service';

@NgModule({
  declarations: [BlogUserComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [BlogUserService]
})
export class BlogUserModule { }