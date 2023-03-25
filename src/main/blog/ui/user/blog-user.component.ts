// blog-user-edit.component.ts
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { BlogUserService } from '../blog-user.service';
import { BlogUser } from '../models/blog-user';

@Component({
  selector: 'app-blog-user-edit',
  templateUrl: './blog-user-edit.component.html',
  styleUrls: ['./blog-user-edit.component.css']
})
export class BlogUserEditComponent implements OnInit {
  blogUserForm: FormGroup;
  blogUser: BlogUser;
  blogUserId: number;

  constructor(private fb: FormBuilder,
              private blogUserService: BlogUserService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.blogUserForm = this.fb.group({
      userName: ['', Validators.required],
      password: ['', Validators.required],
      login: ['', Validators.required]
    });

    this.blogUserId = +this.route.snapshot.paramMap.get('id');
    this.blogUserService.getBlogUser(this.blogUserId).subscribe(blogUser => {
      this.blogUser = blogUser;
      this.blogUserForm.patchValue({
        userName: blogUser.userName,
        password: blogUser.password,
        login: blogUser.login
      });
