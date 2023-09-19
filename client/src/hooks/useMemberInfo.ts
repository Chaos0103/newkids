import { useEffect } from 'react';
import { useRecoilState } from 'recoil';
import { MemberInfoState } from 'store/auth';
import { getMemberInfoApi } from 'utils/apis/auth';

function useMemberInfo() {
	const [memberInfoState, setMemberInfoState] = useRecoilState(MemberInfoState);
	const memberkey = localStorage.getItem('memberkey');

	const fetchData = async (resMemberkey: string) => {
		try {
			const response = await getMemberInfoApi(resMemberkey);
			setMemberInfoState(response.data.data);
		} catch (error) {
			console.log(error);
		}
	};

	useEffect(() => {
		if (memberkey) {
			fetchData(memberkey);
		}
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, [memberkey]);

	return memberInfoState;
}

export default useMemberInfo;
