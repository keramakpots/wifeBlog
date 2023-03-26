import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { FormGroup, FormControl, Validators } from '@angular/forms';



@Injectable({
  providedIn: 'root'
})
export class BlogRecordService {
  private blogRecordsUrl = '/api/blogRecords';
  private blogRecords$ = new BehaviorSubject<BlogRecord[]>([]);
  public readonly blogRecordsForm = new FormGroup({
    blogTextEntry: new FormControl('', [Validators.required]),
    author: new FormControl('', [Validators.required]),
    date: new FormControl('', [Validators.required]),
  });

  constructor(private http: HttpClient) { }

  getAllBlogRecords(): Observable<BlogRecord[]> {
    return this.http.get<BlogRecord[]>(this.blogRecordsUrl)
      .pipe(tap(blogRecords => this.blogRecords$.next(blogRecords)));
  }

  getBlogRecordById(id: number): Observable<BlogRecord> {
    return this.http.get<BlogRecord>(`${this.blogRecordsUrl}/${id}`);
  }

  createBlogRecord(blogRecord: BlogRecord): Observable<BlogRecord> {
    return this.http.post<BlogRecord>(this.blogRecordsUrl, blogRecord)
      .pipe(tap(newBlogRecord => {
        const currentBlogRecords = this.blogRecords$.value;
        currentBlogRecords.push(newBlogRecord);
        this.blogRecords$.next(currentBlogRecords);
      }));
  }

  deleteBlogRecord(id: number): Observable<void> {
    return this.http.delete<void>(`${this.blogRecordsUrl}/${id}`)
      .pipe(tap(() => {
        const currentBlogRecords = this.blogRecords$.value;
        const indexToDelete = currentBlogRecords.findIndex(record => record.id === id);
        if (indexToDelete >= 0) {
          currentBlogRecords.splice(indexToDelete, 1);
          this.blogRecords$.next(currentBlogRecords);
        }
      }));
  }

  get blogRecords(): Observable<BlogRecord[]> {
    return this.blogRecords$.asObservable();
  }
}
