/* eslint-disable react/jsx-no-useless-fragment */
import React, { ReactNode, useEffect } from 'react';
import { useRecoilState } from 'recoil';
import { MemberInfoState } from 'store/auth';
import { getMemberInfoApi } from 'utils/apis/auth';

function AuthProvider({ children }: { children: ReactNode }) {
	const [, setMemberInfoState] = useRecoilState(MemberInfoState);

	const fetchMemberInfoData = async () => {
		const token = localStorage.getItem('token');
		const memberkey = localStorage.getItem('memberkey');
		try {
			if (token && memberkey) {
				const response = await getMemberInfoApi(memberkey);
				if (response.status === 200) {
					setMemberInfoState(response.data.data);
				}
			}
		} catch (error) {
			console.log(error);
		}
	};

	useEffect(() => {
		fetchMemberInfoData();
	}, []);

	return <>{children}</>;
}

export default AuthProvider;
