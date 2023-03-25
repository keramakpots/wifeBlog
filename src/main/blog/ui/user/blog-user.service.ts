import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { FormGroup, FormControl, Validators } from '@angular/forms';



@Injectable({
  providedIn: 'root'
})
export class BlogUserService {
  private blogUsersUrl = '/api/blogUsers';
  private blogUsers$ = new BehaviorSubject<BlogUser[]>([]);
  public readonly blogUsersForm = new FormGroup({
    userName: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required]),
    login: new FormControl('', [Validators.required]),
  });

  constructor(private http: HttpClient) { }

  getAllBlogUsers(): Observable<BlogUser[]> {
    return this.http.get<BlogUser[]>(this.blogUsersUrl)
      .pipe(tap(blogUsers => this.blogUsers$.next(blogUsers)));
  }

  getBlogUserById(id: number): Observable<BlogUser> {
    return this.http.get<BlogUser>(`${this.blogUsersUrl}/${id}`);
  }

  createBlogUser(blogUser: BlogUser): Observable<BlogUser> {
    return this.http.post<Blog
