// blog-record-edit.component.ts
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { BlogRecordService } from '../blog-record.service';
import { BlogRecord } from '../models/blog-record';

@Component({
  selector: 'app-blog-record-edit',
  templateUrl: './blog-record-edit.component.html',
  styleUrls: ['./blog-record-edit.component.css']
})
export class BlogRecordEditComponent implements OnInit {
  blogRecordForm: FormGroup;
  blogRecord: BlogRecord;
  blogRecordId: number;

  constructor(private fb: FormBuilder,
              private blogRecordService: BlogRecordService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.blogRecordForm = this.fb.group({
      blogTextEntry: ['', Validators.required],
      author: ['', Validators.required],
      date: ['', Validators.required]
    });

    this.blogRecordId = +this.route.snapshot.paramMap.get('id');
    this.blogRecordService.getBlogRecord(this.blogRecordId).subscribe(blogRecord => {
      this.blogRecord = blogRecord;
      this.blogRecordForm.patchValue({
        blogTextEntry: blogRecord.blogTextEntry,
        author: blogRecord.author,
        date: blogRecord.date
      });
    });
  }

  onSubmit(): void {
    this.blogRecordService.updateBlogRecord(this.blogRecordId, this.blogRecordForm.value).subscribe(() => {
      this.router.navigate(['/blog-records']);
    });
  }
}


