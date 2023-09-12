import { LoginApiBody } from 'types/api';
import { instance } from './instance';

export const loginApi = async (body: LoginApiBody) => {
	const response = await instance.post('/user-service/login', JSON.stringify(body));
	return response;
};
