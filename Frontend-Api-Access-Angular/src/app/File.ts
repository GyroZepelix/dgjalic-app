import { Customer } from "./Customer";

export class TheFile {
    id: number;
    docName: string;
    docType: string;
    docSize: number;
    data: Uint8Array;
    customer: Customer;
  }