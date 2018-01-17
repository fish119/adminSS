package site.fish119.adminss.service.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.fish119.adminss.domain.sys.Authority;
import site.fish119.adminss.repository.SysAuthorityRepository;

import java.util.List;

@Service
public class AuthorityService {
    @Autowired
    private SysAuthorityRepository authorityRepository;

    public List<Authority> findAllAuthority() {
        return authorityRepository.findByParentIsNullOrderBySortAsc();
    }

    @Transactional
    public Authority saveAuthority(Long parentId, Authority subAuthority) {
        Authority authority;
        if (parentId != null) {
            authority = authorityRepository.findOne(parentId);
            if (subAuthority.getId() != null) {
                subAuthority.setParent(authority);
                return authorityRepository.save(subAuthority);
            } else {
                authority.getChildren().add(subAuthority);
                subAuthority.setParent(authority);
                return authorityRepository.save(authority);
            }
        } else {
            if(subAuthority.getChildren().iterator().hasNext()) {
                Authority trueSubMenu = subAuthority.getChildren().iterator().next();
                trueSubMenu.setParent(subAuthority);
                return authorityRepository.save(trueSubMenu);
            }else{
                return authorityRepository.save(subAuthority);
            }
        }
    }

    @Transactional()
    public void delAuthority(Long id){
        authorityRepository.delete(id);
    }

    @Transactional()
    public void delSubAuthority(Long parentId,Long id){
        Authority parentAuthority = authorityRepository.findOne(parentId);
        Authority authority = authorityRepository.findOne(id);
        authority.setParent(null);
        parentAuthority.getChildren().remove(authority);
        authorityRepository.delete(authority);
    }
}
