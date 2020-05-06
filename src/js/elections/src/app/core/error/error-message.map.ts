import { ErrorMessage } from './error-message.model';

const errorMessages = [
  {
    code: 'E001',
    value: new ErrorMessage('Wprowadzony login lub hasło jest nieprawidłowe. Popraw dane i spróbuj ponownie')
  },
  {
    code: 'E002',
    value: new ErrorMessage('Dany użytkownik już istnieje')
  },
  {
    code: 'E003',
    value: new ErrorMessage('Błąd pobierania regionów. Zgłoś ten przypadek do administratora')
  },
  {
    code: 'E004',
    value: new ErrorMessage('Obecnie nie trwają żadne wybory. Spóbuj później')
  },
  {
    code: 'default',
    value: new ErrorMessage('Błąd. Zgłoś ten przypadek do administratora')
  }
];

const mapperFor = map => map.map((obj: { code: string; value }) => [obj.code, obj.value]);

export const ErrorMessageMap = new Map<string, ErrorMessage>(mapperFor(errorMessages));
