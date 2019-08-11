import {AfterViewInit, Component, ElementRef} from '@angular/core';
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements AfterViewInit {

  public title = "Coffee-Shop Example Sandbox";

  constructor(private elementRef: ElementRef, public titleService: Title) {
    this.titleService.setTitle(this.title);
  }

  ngAfterViewInit() {
    this.elementRef.nativeElement.ownerDocument.body.style.backgroundColor = 'gainsboro';
  }
}
