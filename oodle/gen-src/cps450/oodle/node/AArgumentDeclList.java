/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class AArgumentDeclList extends PArgumentDeclList
{
    private PArgumentDeclList2 _argumentDeclList2_;
    private PArgumentDecl _argumentDecl_;

    public AArgumentDeclList()
    {
        // Constructor
    }

    public AArgumentDeclList(
        @SuppressWarnings("hiding") PArgumentDeclList2 _argumentDeclList2_,
        @SuppressWarnings("hiding") PArgumentDecl _argumentDecl_)
    {
        // Constructor
        setArgumentDeclList2(_argumentDeclList2_);

        setArgumentDecl(_argumentDecl_);

    }

    @Override
    public Object clone()
    {
        return new AArgumentDeclList(
            cloneNode(this._argumentDeclList2_),
            cloneNode(this._argumentDecl_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAArgumentDeclList(this);
    }

    public PArgumentDeclList2 getArgumentDeclList2()
    {
        return this._argumentDeclList2_;
    }

    public void setArgumentDeclList2(PArgumentDeclList2 node)
    {
        if(this._argumentDeclList2_ != null)
        {
            this._argumentDeclList2_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._argumentDeclList2_ = node;
    }

    public PArgumentDecl getArgumentDecl()
    {
        return this._argumentDecl_;
    }

    public void setArgumentDecl(PArgumentDecl node)
    {
        if(this._argumentDecl_ != null)
        {
            this._argumentDecl_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._argumentDecl_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._argumentDeclList2_)
            + toString(this._argumentDecl_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._argumentDeclList2_ == child)
        {
            this._argumentDeclList2_ = null;
            return;
        }

        if(this._argumentDecl_ == child)
        {
            this._argumentDecl_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._argumentDeclList2_ == oldChild)
        {
            setArgumentDeclList2((PArgumentDeclList2) newChild);
            return;
        }

        if(this._argumentDecl_ == oldChild)
        {
            setArgumentDecl((PArgumentDecl) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
