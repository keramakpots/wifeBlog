export interface BlogUser {
  id: number;
  userName: string;
  password: string;
  login: string;
}

export interface BlogRecord {
  id: number;
  blogTextEntry: string;
  author: string;
  date: string;
}