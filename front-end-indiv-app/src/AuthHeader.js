export default function AuthHeader() {
    const user = localStorage.getItem('accesstoken');
    if (user) {
        return { Authorization: 'Bearer ' + user };
    } else {
        return {};
    }
}