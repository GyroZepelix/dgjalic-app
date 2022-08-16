import { Component, EventEmitter, HostBinding, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.css']
})
export class ButtonComponent implements OnInit {

  
  @Input() name: string;
  @Input() color?: string = "";
  @Input() invert?: string = ""; 
  @Output() buttonPressedEvent = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
    
  }

  buttonPressed() {
    this.buttonPressedEvent.emit();
  }

}
