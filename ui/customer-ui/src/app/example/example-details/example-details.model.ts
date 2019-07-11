export class ExampleDetailsModel {
  private _id: number;
  private _name: string;
  private _email: string;
  private _imageUrl: string;
  private _price: number;

  constructor(id?: number, name?: string, email?: string, imageUrl?: string, price?: number) {
    this._id = id;
    this._name = name;
    this._email = email;
    this._imageUrl = imageUrl;
    this._price = price;
  }

  get email(): string {
    return this._email;
  }

  set email(value: string) {
    this._email = value;
  }

  get imageUrl(): string {
    return this._imageUrl;
  }

  set imageUrl(value: string) {
    this._imageUrl = value;
  }

  get price(): number {
    return this._price;
  }

  set price(value: number) {
    this._price = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }
}
