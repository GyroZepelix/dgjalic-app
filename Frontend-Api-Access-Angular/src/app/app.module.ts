import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TableComponent } from './components/table/table.component';
import { FigureComponent } from './components/figure/figure.component';
import { HeaderComponent } from './components/header/header.component';
import { DropdownComponent } from './components/dropdown/dropdown.component';
import { MainComponent } from './components/main/main.component';
import { ButtonComponent } from './components/button/button.component';
import { HttpClientModule } from '@angular/common/http';
import { InputComponent } from './components/input/input.component';
import { FileTableComponent } from './components/file-table/file-table.component';
@NgModule({
  declarations: [
    AppComponent,
    TableComponent,
    FigureComponent,
    HeaderComponent,
    DropdownComponent,
    MainComponent,
    ButtonComponent,
    InputComponent,
    FileTableComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
